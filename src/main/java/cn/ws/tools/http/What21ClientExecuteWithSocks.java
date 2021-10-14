package cn.ws.tools.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
 
public class What21ClientExecuteWithSocks {
 
    public static void main(String[] args) throws Exception {
        // ConnectionSocketFactory注册
        Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", new MyConnectionSocketFactory())
                .build();
        // HTTP客户端连接管理池
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(reg);
        CloseableHttpClient httpclient = HttpClients.custom()
                    .setConnectionManager(connManager)
                    .build();
        try {
            // socks代理地址
            InetSocketAddress socksaddr = new InetSocketAddress("192.168.1.9", 1080);
            HttpClientContext context = HttpClientContext.create();
            context.setAttribute("socks.address", socksaddr);
             
            // 请求目标
            HttpHost target = new HttpHost("c57779.818tu.com");
            HttpGet request = new HttpGet("/v1/search?gender=male&status=&category=%E9%83%BD%E5%B8%82%E6%83%85%E6%84%9F&limit=0&start=10&highlight=1");
            System.out.println("----------------------------------------");
            System.out.println("执行请求 ：" + request.getRequestLine());
            System.out.println("通过代理： " + socksaddr);
            System.out.println("执行目录： " + target);
            System.out.println("----------------------------------------");
 
            CloseableHttpResponse response = httpclient.execute(target, request, context);
            try {
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                System.out.println("返回响应：" + response.getStatusLine());
                System.out.println("响应内容：" + EntityUtils.toString(entity));
                System.out.println("----------------------------------------");
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
 
    static class MyConnectionSocketFactory implements ConnectionSocketFactory {
 
        @Override
        public Socket createSocket(final HttpContext context) throws IOException {
            InetSocketAddress socksaddr = (InetSocketAddress) context.getAttribute("socks.address");
            // socket代理
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, socksaddr);
            return new Socket(proxy);
        }
 
        @Override
        public Socket connectSocket(
                final int connectTimeout,
                final Socket socket,
                final HttpHost host,
                final InetSocketAddress remoteAddress,
                final InetSocketAddress localAddress,
                final HttpContext context) throws IOException, ConnectTimeoutException {
            Socket sock;
            if (socket != null) {
                sock = socket;
            } else {
                sock = createSocket(context);
            }
            if (localAddress != null) {
                sock.bind(localAddress);
            }
            try {
                sock.connect(remoteAddress, connectTimeout);
            } catch (SocketTimeoutException ex) {
                throw new ConnectTimeoutException(ex, host, remoteAddress.getAddress());
            }
            return sock;
        }
 
    }
 
}