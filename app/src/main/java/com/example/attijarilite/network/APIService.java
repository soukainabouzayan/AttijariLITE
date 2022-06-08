package com.example.attijarilite.network;

import com.example.attijarilite.model.Account;
import com.example.attijarilite.model.Card;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("auth/realms/attijarilite-realm/protocol/openid-connect/token")
    Call<AccessToken> getAccessToken(@Field("client_id") String client_id,
                                     @Field("grant_type") String grant_type,
                                     @Field("client_secret") String client_secret,
                                     @Field("scope") String scope,
                                     @Field("username") String identifier,
                                     @Field("password") String password);
    @GET("/account/all")
    Call<List<Account>> getAllAccounts();
    @GET("/card/all")
    Call<List<Card>> getAllCards();
    @GET
    Call<Account> getAccountByAccountNumber(String accountNumber);
}
