package com.nxd.ftt.mchelper.util;

import com.google.gson.Gson;
import com.nxd.ftt.mchelper.entity.server.ServerInfo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.regex.Pattern;

/**
 * ServerUtil
 *
 * @author luhangqi
 * @date 2018/6/7
 */
public class ServerUtil {

    private Pattern pattern = Pattern.compile("(§.{0,1})|(\\\\n)");
    private InetSocketAddress host;
    private int timeout = 70000;
    private Gson gson = new Gson();

    public void setAddress(InetSocketAddress host) {
        this.host = host;
    }

    public InetSocketAddress getAddress() {
        return this.host;
    }

    void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    int getTimeout() {
        return this.timeout;
    }

    public int readVarInt(DataInputStream in) throws IOException {
        int i = 0;
        int j = 0;
        while (true) {
            int k = in.readByte();
            i |= (k & 0x7F) << j++ * 7;
            if (j > 5) {
                throw new RuntimeException("VarInt too big");
            }
            if ((k & 0x80) != 128) {
                break;
            }
        }
        return i;
    }

    public void writeVarInt(DataOutputStream out, int paramInt) throws IOException {
        while (true) {
            if ((paramInt & 0xFFFFFF80) == 0) {
                out.writeByte(paramInt);
                return;
            }

            out.writeByte(paramInt & 0x7F | 0x80);
            paramInt >>>= 7;
        }
    }

    public ServerInfo fetchData() {

        Socket socket = new Socket();
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;

        ServerInfo response = null;
        try {
            socket.setSoTimeout(this.timeout);
            socket.connect(host, timeout);
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);

            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream handshake = new DataOutputStream(b);
            //packet id for handshake
            handshake.writeByte(0x00);
            //protocol version
            writeVarInt(handshake, 4);
            //host length
            writeVarInt(handshake, this.host.getHostString().length());
            //host string
            handshake.writeBytes(this.host.getHostString());
            //port
            handshake.writeShort(host.getPort());
            //state (1 for handshake)
            writeVarInt(handshake, 1);

            //prepend size
            writeVarInt(dataOutputStream, b.size());
            //write handshake packet
            dataOutputStream.write(b.toByteArray());


            //size is only 1
            dataOutputStream.writeByte(0x01);
            //packet id for ping
            dataOutputStream.writeByte(0x00);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            //size of packet
            int size = readVarInt(dataInputStream);
            //packet id
            int id = readVarInt(dataInputStream);

            if (id == -1) {
                throw new IOException("Premature end of stream.");
            }

            //we want a status response
            if (id != 0x00) {
                throw new IOException("Invalid packetID");
            }
            //length of json string
            int length = readVarInt(dataInputStream);

            if (length == -1) {
                throw new IOException("Premature end of stream.");
            }

            if (length == 0) {
                throw new IOException("Invalid string length.");
            }

            byte[] in = new byte[length];
            //read json string
            dataInputStream.read(in);
            String json = new String(in);
            json = pattern.matcher(json).replaceAll("");

//        long now = System.currentTimeMillis();
//        dataOutputStream.writeByte(0x09); //size of packet
//        dataOutputStream.writeByte(0x01); //0x01 for ping
//        dataOutputStream.writeLong(now); //time!?

//        readVarInt(dataInputStream);
//        id = readVarInt(dataInputStream);
//        if (id == -1) {
//            throw new IOException("Premature end of stream.");
//        }
//
//        if (id != 0x01) {
//            throw new IOException("Invalid packetID");
//        }
//        long pingtime = dataInputStream.readLong(); //read response

            response = gson.fromJson(json, ServerInfo.class);
//        response.setTime((int) (now - pingtime));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataOutputStream.close();
                outputStream.close();
                inputStreamReader.close();
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return response;
    }
}
