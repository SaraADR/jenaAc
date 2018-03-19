
package jenaactividad;


import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.jena.atlas.json.JsonArray;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.DC_11;


public class JenaActividad {
    static String URI = "https://opendata.aemet.es/opendata/api/valores/climatologicos/inventarioestaciones/todasestaciones/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzYXJhLmFycmRyQGdtYWlsLmNvbSIsImp0aSI6IjIzOWQxYTUyLTA3YTUtNDZkMS05ODRjLTI0NTExZWViNDU3NiIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNTIxNDU2NDMyLCJ1c2VySWQiOiIyMzlkMWE1Mi0wN2E1LTQ2ZDEtOTg0Yy0yNDUxMWVlYjQ1NzYiLCJyb2xlIjoiIn0.0w-qexszcPCGIhi1xUFt4SbAJhE0oE5BIc9Shrz6lDo";
    static String datosURI= "https://opendata.aemet.es/opendata/sh/a112da84";
            
    public static void main(String[] args) throws IOException {
     
        System.setProperty("javax.net.ssl.trustStore", "C:/Users/Entrar/keystore.jks");
        System.out.println(inicializaAEMET(URI).body().string()); 
        System.out.println(inicializaAEMET(datosURI).body().string()); 

        JsonArray array = Json.createArrayBuilder().build();


    }
    
    public static Response inicializaAEMET(String uri) throws IOException{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url(uri)
        .get()
        .addHeader("cache-control", "no-cache")
        .build();
        try{
            Response response = client.newCall(request).execute();
            return response;
        }catch(IOException e){       
            return null;
        }
    }
    
}


