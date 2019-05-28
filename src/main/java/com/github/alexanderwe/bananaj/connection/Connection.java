package com.github.alexanderwe.bananaj.connection;

import com.github.alexanderwe.bananaj.exceptions.TransportException;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by Alexander on 10.08.2016.
 */
public class Connection implements AutoCloseable {

    public static PoolingHttpClientConnectionManager pool = null; // Should be overriden
    private final CloseableHttpClient                       httpClient;
    private final Logger                                    logger;

    public Connection() {

        logger = LoggerFactory.getLogger(Connection.class);
        if (pool != null) {
            httpClient = HttpClients.custom()
                    .setConnectionManager(pool)
                    .setConnectionManagerShared(true)
                    .build();
        } else {
            logger.error("No connection pool has been defined.");
            httpClient = HttpClients.custom()
                    .setConnectionManagerShared(true)
                    .build();
        }

    }

    /**
     * Creates the response from entity.
     *
     * @param entity the entity
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static String createResponseFromEntity(HttpEntity entity) throws IOException {
        InputStream entityStream;
        if (entity != null) {
            long length = entity.getContentLength();
            entityStream = entity.getContent();
            StringBuilder strbuilder = new StringBuilder(
                    length > 16 && length < Integer.MAX_VALUE ? (int) length : 200);
            try (Reader reader = new BufferedReader(
                    new InputStreamReader(entityStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c;
                while ((c = reader.read()) != -1) {
                    strbuilder.append((char) c);
                }
            }
            return strbuilder.toString();
        }
        return null;
    }

    /**
     * Gets the error obj string.
     *
     * @param errObj the err obj
     * @param key    the key
     * @return the error obj string
     */
    private static String getErrorObjString(JSONObject errObj, String key) {
        if (errObj.has(key)) {
            return errObj.getString(key);
        }
        return "";
    }

    /**
     * Do get.
     *
     * @param url           the url
     * @param authorization the authorization
     * @return the string
     * @throws TransportException the transport exception
     * @throws URISyntaxException the URI syntax exception
     */
    @Nullable
    public String do_Get(URL url, String authorization) throws TransportException, URISyntaxException {

        HttpGet httpget = new HttpGet(url.toURI());
        httpget.addHeader("Authorization", authorization);
        try (CloseableHttpResponse response = httpClient.execute(httpget)) {

            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode < 200 || responseCode > 299) {
                throw buildTransportError("GET", url.toExternalForm(), response);
            }

            return createResponseFromEntity(response.getEntity());
        } catch (Exception e) {
            logger.error("doGet:FAILED {}", e.getMessage(), e);
            throw new TransportException("GET " + url.toExternalForm() + " failed", e);
        }
    }

    /**
     * Do post.
     *
     * @param url           the url
     * @param post_string   the post string
     * @param authorization the authorization
     * @return the string
     * @throws TransportException the transport exception
     * @throws URISyntaxException the URI syntax exception
     */
    @Nullable
    public String do_Post(URL url, String post_string, String authorization)
            throws TransportException, URISyntaxException {

        HttpPost httppost = new HttpPost(url.toURI());
        httppost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httppost.addHeader("Authorization", authorization);
        httppost.setEntity(EntityBuilder.create().setBinary(post_string.getBytes(StandardCharsets.UTF_8)).build());

        try (CloseableHttpResponse response = httpClient.execute(httppost)) {

            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode < 200 || responseCode > 299) {
                throw buildTransportError("POST", url.toExternalForm(), response);
            }

            return createResponseFromEntity(response.getEntity());
        } catch (Exception e) {
            logger.error("doPost:FAILED {}", e.getMessage(), e);
            throw new TransportException(
                    "POST " + post_string.length() + " bytes to " + url.toExternalForm() + " failed", e);
        }
    }

    /**
     * Do patch.
     *
     * @param url           the url
     * @param patch_string  the patch string
     * @param authorization the authorization
     * @return the string
     * @throws TransportException the transport exception
     * @throws URISyntaxException the URI syntax exception
     */
    @Nullable
    public String do_Patch(URL url, String patch_string, String authorization)
            throws TransportException, URISyntaxException {

        HttpPatch httppatch = new HttpPatch(url.toURI());
        httppatch.addHeader("Content-Type", "application/json; charset=UTF-8");
        httppatch.addHeader("Authorization", authorization);
        httppatch.setEntity(EntityBuilder.create().setBinary(patch_string.getBytes(StandardCharsets.UTF_8)).build());

        try (CloseableHttpResponse response = httpClient.execute(httppatch)) {

            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode < 200 || responseCode > 299) {
                throw buildTransportError("PATCH", url.toExternalForm(), response);
            }

            return createResponseFromEntity(response.getEntity());
        } catch (Exception e) {
            logger.error("doPatch:FAILED {}", e.getMessage(), e);
            throw new TransportException(
                    "PATCH " + patch_string.length() + " bytes to " + url.toExternalForm() + " failed", e);
        }
    }

    /**
     * Do put.
     *
     * @param url           the url
     * @param put_string    the put string
     * @param authorization the authorization
     * @return the string
     * @throws TransportException the transport exception
     * @throws URISyntaxException the URI syntax exception
     */
    public String do_Put(URL url, String put_string, String authorization)
            throws TransportException, URISyntaxException {

        HttpPut httpput = new HttpPut(url.toURI());
        httpput.addHeader("Content-Type", "application/json; charset=UTF-8");
        httpput.addHeader("Authorization", authorization);
        httpput.setEntity(EntityBuilder.create().setBinary(put_string.getBytes(StandardCharsets.UTF_8)).build());

        try (CloseableHttpResponse response = httpClient.execute(httpput);) {

            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode < 200 || responseCode > 299) {
                throw buildTransportError("PUT", url.toExternalForm(), response);
            }

            return createResponseFromEntity(response.getEntity());
        } catch (Exception e) {
            logger.error("doPut:FAILED {}", e.getMessage(), e);
            throw new TransportException("PUT " + put_string.length() + " bytes to " + url.toExternalForm() + " failed",
                    e);
        }
    }

    /**
     * Do post.
     *
     * @param url           the url
     * @param authorization the authorization
     * @return the string
     * @throws TransportException the transport exception
     * @throws URISyntaxException the URI syntax exception
     */
    @Nullable
    public String do_Post(URL url, String authorization) throws TransportException, URISyntaxException {

        HttpPost httppost = new HttpPost(url.toURI());
        httppost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httppost.addHeader("Authorization", authorization);
        try (CloseableHttpResponse response = httpClient.execute(httppost)) {

            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode < 200 || responseCode > 299) {
                throw buildTransportError("POST", url.toExternalForm(), response);
            }

            return createResponseFromEntity(response.getEntity());
        } catch (Exception e) {
            logger.error("doPost:FAILED {}", e.getMessage(), e);
            throw new TransportException("POST " + url.toExternalForm() + " failed", e);
        }
    }

    /**
     * Do delete.
     *
     * @param url           the url
     * @param authorization the authorization
     * @return the string
     * @throws TransportException the transport exception
     * @throws URISyntaxException the URI syntax exception
     */
    public String do_Delete(URL url, String authorization) throws TransportException, URISyntaxException {

        HttpDelete httpdelete = new HttpDelete(url.toURI());
        httpdelete.addHeader("Content-Type", "application/json; charset=UTF-8");
        httpdelete.addHeader("Authorization", authorization);

        try (CloseableHttpResponse response = httpClient.execute(httpdelete)) {

            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode < 200 || responseCode > 299) {
                throw buildTransportError("DELETE", url.toExternalForm(), response);
            }

            return createResponseFromEntity(response.getEntity());
        } catch (Exception e) {
            logger.error("doDelete:FAILED {}", e.getMessage(), e);
            throw new TransportException("DELETE " + url.toExternalForm() + " failed", e);
        }
    }

    /**
     * Builds the transport error.
     *
     * @param verb     the verb
     * @param url      the url
     * @param response the response
     * @return the transport exception
     */
    private TransportException buildTransportError(String verb, String url, CloseableHttpResponse response) {
        int responseCode = response.getStatusLine().getStatusCode();
        JSONObject errObj;
        try {
            errObj = new JSONObject(createResponseFromEntity(response.getEntity()));
            String errType = getErrorObjString(errObj, "type");
            String errTitle = getErrorObjString(errObj, "title");
            String errDetail = getErrorObjString(errObj, "detail");
            String errInstance = getErrorObjString(errObj, "instance");
            return new TransportException("Status: " + Integer.toString(responseCode) + " " + verb + ": " + url
                    + " Reason: " + response.getStatusLine().getReasonPhrase()
                    + " - " + errTitle + " Details: " + errDetail + " Instance: " + errInstance + " Type: " + errType);
        } catch (IOException | JSONException e) {
            logger.error("BuildTransportError {}", e.getMessage(), e);
        }
        return new TransportException("Status: " + Integer.toString(responseCode) + " " + verb + ": " + url
                + " Reason: " + response.getStatusLine().getReasonPhrase());
    }

    @Override
    public void close() throws Exception {
        httpClient.close();
    }
}
