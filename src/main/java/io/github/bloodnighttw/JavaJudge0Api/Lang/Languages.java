package io.github.bloodnighttw.JavaJudge0Api.Lang;

import com.google.gson.Gson;
import io.github.bloodnighttw.JavaJudge0Api.Submissions.DefaultSubmission;
import io.github.bloodnighttw.JavaJudge0Api.Submissions.SubmissionBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Languages {

    public static void main(String[] args) throws IOException {

        System.out.println(Languages.getSupportLangs("http://localhost:3000"));

        for(Language language:Languages.getSupportLangs("http://localhost:3000"))
            System.out.println(language.getId()+" "+language.getName());

        SubmissionBuilder submissionBuilder=new SubmissionBuilder("prit%20%22sssssss%22",70);

        DefaultSubmission defaultSubmission=submissionBuilder.build();

        System.out.println(defaultSubmission.getToken());

    }

    private static Languages instance;
    private Language[] langs;


    public static Language[] getSupportLangs(String serverUrl) throws IOException {
        if(instance==null){
            HttpClient httpClient=new DefaultHttpClient();
            HttpGet httpGet=new HttpGet(serverUrl+"/languages");
            HttpResponse httpResponse=httpClient.execute(httpGet);

            String response= EntityUtils.toString(httpResponse.getEntity());
            instance=new Gson().fromJson("{\"langs\":"+response+"}",Languages.class);
            System.out.println("{\"langs\":"+response+"}");
        }

        return instance.langs;
    }
}
