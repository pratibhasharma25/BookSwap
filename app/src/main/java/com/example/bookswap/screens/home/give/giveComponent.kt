@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bookswap.screens.home.give

import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import com.example.bookswap.R


@Composable
fun GiveInputText(modifier: Modifier,
                  text: String,
                  label: String,
                  maxLine: Int = 5,
                  onTextChange: (String) -> Unit,
                  onImeAction: () -> Unit ={}
){
    val keyController = LocalSoftwareKeyboardController.current
    TextField(value = text, onValueChange = onTextChange,
        maxLines = maxLine,
        label = {Text(text=label)},
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {onImeAction()
        keyController?.hide()}
        ),
        modifier = modifier)


}


@Composable
fun GiveButton(modifier: Modifier,
               text: String,
               onClick: ()->Unit,
               enabled: Boolean = true){
    Button(onClick = onClick, modifier = Modifier,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.darkBase),
            contentColor = colorResource(id = R.color.lightBase))
            ) {

        Text(text)
        
    }

}