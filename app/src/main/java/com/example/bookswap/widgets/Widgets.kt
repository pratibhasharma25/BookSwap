package com.example.bookswap.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.bookswap.R
import com.example.bookswap.model.Book
import com.example.bookswap.model.getBook
import com.example.bookswap.screens.home.take.BookImage
import java.nio.file.attribute.AclEntry.Builder
import java.nio.file.attribute.AclEntry.newBuilder
import java.util.UUID

@Preview
@Composable
fun BookRow(book: Book = getBook()[0], onItemClick: (UUID) -> Unit = {} ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(5.dp)
                .clickable {
                    onItemClick(book.id)
                },
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.lightBase),
                contentColor = colorResource(id = R.color.darkBase),
            )
        ) {
            Row {
                AsyncImage(
                    model = book.images,
                    contentDescription = "Placeholder Image",
                    modifier = Modifier.fillMaxHeight().width(100.dp).padding(2.dp).clip(
                        RoundedCornerShape(10.dp)
                    ),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(alignment = Alignment.CenterVertically)
                ) {
                    Text(text = "${book.name} ", modifier = Modifier,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(text = "${book.author} (Ed-${book.edition}) " ,
                        style = TextStyle(
                            fontSize = 15.sp
                    ))
                    Text(text = " Contact - ${book.phone} " ,
                        style = TextStyle(
                            fontSize = 15.sp
                        ))
                    Text(text = "₹${book.price}" ,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        ))
                }
            }

        }

    }

