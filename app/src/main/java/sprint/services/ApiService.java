package sprint.services;

import sprint.models.Produto;
import sprint.models.ProdutoJson;

import java.util.List;
import retrofit2.*;
import retrofit2.http.GET;

public interface ApiService {
    @GET("products")
    Call<List<ProdutoJson>> getProdutos();
}