package com.example.corrutinas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.corrutinas.ui.theme.CorrutinasTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var retrofit = RetrofitHelper.getInstance()
        lifecycleScope.launch(Dispatchers.IO){
            val resultado: Response<SuperHeroDataResponse> = retrofit.getSuperheroes("a")
            withContext(Dispatchers.Main){
                if (resultado.isSuccessful) {
                    Log.i("ejemplo", "$resultado")
                    Log.i("ejemplo", "${resultado.body()}")
                }
            }
        }
        setContent {
            CorrutinasTheme {
                Surface {
                    SuperHeroList()
                }
            }
        }
    }
}

@Composable
fun SuperHeroList() {
//    Text(
//        text = resultado
//    )


}
