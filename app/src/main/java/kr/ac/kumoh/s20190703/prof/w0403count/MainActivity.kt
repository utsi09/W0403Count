package kr.ac.kumoh.s20190703.prof.w0403count

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20190703.prof.w0403count.ui.theme.W0403CountTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyApp{
               Column{
                   Counter()
                   Counter()
                   Counter()
               }

           }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    W0403CountTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0)}

    Column(modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$count",fontSize = 200.sp)
        Row() {
            Button(modifier = Modifier.weight(1f),
                onClick = {
                    count++
                    Log.i("Counter: ", count.toString())
                }
            ) {
                Text(text = "증가")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(modifier = Modifier.weight(1f),
                onClick = {
                    if(count > 0){
                    count--}
                    Log.i("Counter: ", count.toString())
                }
            ){
                Text(text = "감소")
            }


        }


    }

}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() = MyApp{
    Counter()
}