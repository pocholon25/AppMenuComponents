package pe.edu.idat.appmenucomponents

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun EjemploBottomBar() {
    val items = listOf("Home", "Contactos", "Perfil", "Buson")
    val iconos = listOf(
        Icons.Filled.Home,
        Icons.Filled.Call,
        Icons.Filled.Person,
        Icons.Filled.Email)
    var itemSeleccionado by remember { mutableStateOf(0) }
    BottomAppBar(
        containerColor = colorResource(id = R.color.teal_200),
        contentColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = itemSeleccionado == index,
                onClick = { itemSeleccionado = index },
                icon = { Icon(imageVector = iconos[index], contentDescription = "", tint = Color.Red) },
                label = { Text(text = item) })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploToolBar() {
    TopAppBar(
        title = { Text(text = "MiniMarket Julita", style = MaterialTheme.typography.bodyMedium, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor =colorResource(id = R.color.teal_200),
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.Red
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    contentDescription = "",
                    tint = Color.Red
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = "",
                    tint = Color.Red
                )
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EjemploScaffold() {
    var estado = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(topBar = { EjemploToolBar() },
        snackbarHost = {
            SnackbarHost(hostState = estado)
        },
        content = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(onClick = {
                    coroutineScope.launch {
                        estado.showSnackbar(
                            "Hola Clickeaste el boton",
                            actionLabel = "OK",
                            duration = SnackbarDuration.Long
                        )
                    }
                }) {
                    Text(text = "Mostrar el Snack Bar")
                }
            }
        },
        bottomBar = {
            EjemploBottomBar()
        })
}


