package com.example.myfirstcomposeapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.dashboard.BottomBarNavigation
import com.example.myfirstcomposeapp.dashboard.DashBoardActivity
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    SplashImage()
                }
            }
        }

        val intent= Intent(this,DashBoardActivity::class.java)
        startActivity(intent)
        finish()
    }
}

@Composable
fun SplashImage() {
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.Magenta,
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize(Alignment.Center),
        border = BorderStroke(1.dp, Color.Blue),




        ) {

        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

            ) {


            Image(
                painter = painterResource(id = R.drawable.ic_splash_screen),
                contentDescription = "Splash Screen",
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp)
//                    .wrapContentSize(Alignment.Center)
                )
            Text(
                text = stringResource(R.string.app_name),
                )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFirstComposeAppTheme {
        SplashImage()
    }
}