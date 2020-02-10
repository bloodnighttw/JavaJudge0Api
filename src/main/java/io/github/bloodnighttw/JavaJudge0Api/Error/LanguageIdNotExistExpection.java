package io.github.bloodnighttw.JavaJudge0Api.Error;

public class LanguageIdNotExistExpection extends Exception {

    public LanguageIdNotExistExpection(int id,String url){
        super("Language_ID: "+id+" didn't exist ! Please cheak "+url+"/languages/all to see all supported languages list.");
    }

}
