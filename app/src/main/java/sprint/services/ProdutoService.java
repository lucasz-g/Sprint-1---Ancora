package sprint.services;

import sprint.models.Produto;
import sprint.models.ProdutoJson;
import retrofit2.*;
import java.util.List;

public class ProdutoService {

    private ApiService apiService;

    public ProdutoService() {
        Retrofit retrofit = RetrofitClient.getClient(); // Verifique se o RetrofitClient está implementado corretamente
        apiService = retrofit.create(ApiService.class);
    }

    public void buscarProdutos(Callback<List<ProdutoJson>> callback) {
        Call<List<ProdutoJson>> call = apiService.getProdutos();
        call.enqueue(callback);
    }
}