package com.johngodoi.java.bairesdev;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Solution {
    /*
     * Complete the function below.
     * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */

    public class Datum {

        @SerializedName("Title")
        @Expose
        private String title;
        @SerializedName("Year")
        @Expose
        private Integer year;
        @SerializedName("imdbID")
        @Expose
        private String imdbID;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

    }
    public class Example {

        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("per_page")
        @Expose
        private Integer perPage;
        @SerializedName("total")
        @Expose
        private Integer total;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;
        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }

    }
    // HTTP GET request
    static String sendGet(String subString) throws Exception {

        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+subString;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();

    }

    static String[] getMovieTitles(String substr) {
        try {
            String json = sendGet(substr);
            Example response = new Gson().fromJson(json, Example.class);
            Stream<Datum> sorted = response.getData().stream();

            List<String> resultsPage1 = sorted.map(d -> d.getTitle()).collect(Collectors.toList());

            for (int i = 1; i < response.getTotalPages(); i++) {
                String json2 = sendGet(substr+"&page="+(i+1));
                Example response2 = new Gson().fromJson(json2, Example.class);
                Stream<Datum> sorted2 = response2.getData().stream();
                resultsPage1.addAll(sorted2.map(d -> d.getTitle()).collect(Collectors.toList()));
            }


            return resultsPage1.stream().sorted((d1, d2) -> d1.compareTo(d2)).toArray(String[]::new);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws IOException{
/*        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }*/

        String [] res = getMovieTitles("Spiderman");/*
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();*/
    }
}