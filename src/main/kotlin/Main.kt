import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.test.Foo
import java.io.File

@Composable
@Preview
fun App(str: String, foo: Foo) {
    var text by remember { mutableStateOf(str) }

    MaterialTheme {
        Button(onClick = {
            val i = foo.nextNumber()
            text = "Hello, $i"
        }) {
            Text(text)
        }
    }
}

fun main() {

    val str = try {
        System.load(File(".").absolutePath + "/build/libtest.jnilib")
        "native library loaded"
    } catch (t: Throwable) {
        t.message ?: "fail"
    }

    val foo = Foo()

    application {
        Window(onCloseRequest = ::exitApplication) {
            App(str, foo)
        }
    }
}
