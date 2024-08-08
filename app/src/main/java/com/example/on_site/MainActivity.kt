package com.example.on_site

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

var checkBox  = mutableStateListOf<Color>(Color.Black,Color.White,Color.White)
var posts  = mutableStateListOf<String>("posts","followers","following")

val imageArray = arrayOf(
    R.drawable.image,
    R.drawable.image2,
    R.drawable.image3
)



val imageMatrix = arrayOf(
    arrayOf(
        R.drawable.nicepicture1,
        R.drawable.nicepicture2,
        R.drawable.nicepicture3,
    ),
    arrayOf(
        R.drawable.image,
        R.drawable.image2,
        R.drawable.image3
    ),
    arrayOf(
        R.drawable.bangone,
        R.drawable.bangtwo,
        R.drawable.bangthree
    ),
    arrayOf(
        R.drawable.bangfour,
        R.drawable.bangfive,
        R.drawable.bangsix
    ),

    arrayOf(
        R.drawable.nicepicture1,
        R.drawable.nicepicture2,
        R.drawable.nicepicture3,
    ),
    arrayOf(
        R.drawable.image,
        R.drawable.image2,
        R.drawable.image3
    ),
    arrayOf(
        R.drawable.bangone,
        R.drawable.bangtwo,
        R.drawable.bangthree
    ),
    arrayOf(
        R.drawable.bangfour,
//        R.drawable.bangfive,
//        R.drawable.bangsix
    )

)
var imageSet by mutableStateOf(false)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            if(imageSet)
            {
                // for learning
                val thread = Thread.currentThread().name
                Log.d("value",thread)

                LaunchedEffect(imageSet) {
                    delay(500L)
                    imageSet = false
                }
            }
            Navigation()
        }
    }
}


@Composable
fun FrontPage(navController: NavHostController)
{
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(0.dp, 5.dp),
        verticalArrangement = Arrangement.Top
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Image(
                painter = painterResource(id = R.drawable.deltaforce),
                contentDescription = "Your Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp,0.dp,0.dp,0.dp)
                    .size(50.dp)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
            )
            Text(text = "D E L T A      F E E D", fontSize = 30.sp, modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp).fillMaxWidth(), textAlign = TextAlign.Center)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(color = Color.Black)
        )
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp,Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Your Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
            )
            Text(text = "delta_nitt", fontSize = 20.sp)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(color = Color.Black)
        )
        Box(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
              ,
        )
        {
                var imageNumber by remember { mutableIntStateOf(0) }

                for(i in 0..2)
                {
                    if(i == imageNumber)
                    {
                        checkBox[i] = Color.Black
                    }
                    else
                    {
                        checkBox[i] = Color.White
                    }
                }
                Image(
                    painter = painterResource(id = imageArray[imageNumber]), // replace with your image resource
                    contentDescription = "Your Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .pointerInput(imageNumber, imageSet) {
                            detectHorizontalDragGestures { _, dragAmount ->
                                if (dragAmount < 0 ) {
                                    Log.d("Swipe", imageNumber.toString())
                                    if(imageNumber <2&& !imageSet)
                                    {
                                        imageNumber += 1
                                        imageSet = true
                                    }
                                    Log.d("Swipe", imageNumber.toString())
                                }

                                if (dragAmount > 0) {
                                    Log.d("Swipe", imageNumber.toString())
                                    if(imageNumber >0 && !imageSet)
                                    {
                                        imageNumber -= 1
                                        imageSet = true
                                    }
                                    Log.d("Swipe", imageNumber.toString())

                                }
                            }
                        },
                )
            // changed to swipe

//            Icon(
//                painter = painterResource(id = R.drawable.forwardarrow),
//                contentDescription = "user",
//                tint =Color.Black,
//                modifier = Modifier
//                    .clickable {
//                        if(imageNumber < 1)
//                        {
//                            imageNumber += 1
//                            checkBox[imageNumber] = Color.Black
//                            checkBox[imageNumber-1] = Color.White
//                        }
//                        else
//                        {
//                            checkBox[imageNumber] = Color.Black
//                            checkBox[imageNumber-1] = Color.White
//                            imageNumber = 0
//                        }
//
//
//                    }
//                    .padding(5.dp)
//                    .size(40.dp)
//                    .align(Alignment.CenterEnd))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .align(Alignment.BottomEnd),
                    horizontalArrangement = Arrangement.spacedBy(30.dp,Alignment.CenterHorizontally)
                )
                {
                    for(i in 0..2)
                    {
                        Circle(checkBox[i], size = 10)
                    }
                }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.Black)
        )

        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp,Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(id = R.drawable.college),
                contentDescription = "Your Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
            )
            Text(text = "thiru_", fontSize = 20.sp, modifier = Modifier.clickable {
                navController.navigate("B")
            })
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(color = Color.Black)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth().height(255.dp),
        ) {
            items(imageArray) { imageResId ->
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Slide Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                       .fillMaxSize()
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(color = Color.Black)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp,5.dp,0.dp,0.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(40.dp,Alignment.CenterHorizontally)
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "home",
                tint =Color.Black,
                modifier = Modifier
                    .clickable {
                    }
                    .padding(5.dp)
                    .size(40.dp))
            Icon(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "user",
                tint =Color.Black,
                modifier = Modifier
                    .clickable {
                    }
                    .padding(5.dp)
                    .size(40.dp))
        }
    }
}

@Composable
fun UserPage(navController: NavHostController)
{
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(0.dp, 5.dp),
        verticalArrangement = Arrangement.Top
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Image(
                painter = painterResource(id = R.drawable.deltaforce),
                contentDescription = "Your Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp,0.dp,0.dp,0.dp)
                    .size(50.dp)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
            )
            Text(text = "D E L T A      F E E D", fontSize = 30.sp, modifier = Modifier.padding(0.dp,0.dp,10.dp,0.dp).fillMaxWidth(), textAlign = TextAlign.Center)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(color = Color.Black)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
               ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Your Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                    .clip(CircleShape)
            )
            for(i in 0..2)
            {
                Column(
                )
                {
                    Text(text = "xyz", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = posts[i], fontWeight = FontWeight.Bold,fontSize = 15.sp)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp,Alignment.Start)
        )
        {
            Text(text = "thiru", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text ="he/him", fontSize = 20.sp)
        }
        Text(text ="may the force be with you", fontSize = 20.sp, modifier = Modifier.padding(10.dp,0.dp,0.dp,10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(color = Color.Black)
        )
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .height(510.dp)
            )
        {

            items(imageMatrix){ imageId ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    )
                    {
                        for(element in imageId)
                        {
                            Image(
                                painter = painterResource(id = element),
                                contentDescription = "Slide Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(131.dp)
                            )
                        }
                    }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(color = Color.Black)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(40.dp,Alignment.CenterHorizontally)
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "home",
                tint =Color.Black,
                modifier = Modifier
                    .clickable {
                        navController.navigate("A")
                    }
                    .padding(5.dp)
                    .size(40.dp))
            Icon(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "user",
                tint =Color.Black,
                modifier = Modifier
                    .clickable {
                    }
                    .padding(5.dp)
                    .size(40.dp))
        }
    }
}

@Composable
fun Circle(color:Color,size :Int)
{
    Box(
        modifier = Modifier
            .background(shape = CircleShape, color = color)
            .size(size.dp)
            .border(width = 2.dp, color = Color.Black, shape = CircleShape)
    )
}
