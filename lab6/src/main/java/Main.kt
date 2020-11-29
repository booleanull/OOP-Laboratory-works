import data.ShapeRepositoryImpl
import data.ShapeSource
import ui.MainForm
import java.awt.Dimension
import javax.swing.JFrame

fun main() {
    val main = JFrame("Shapes")
    val form = MainForm(ShapeRepositoryImpl(ShapeSource()))
    main.contentPane = form.mainPanel
    main.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    main.preferredSize = Dimension(640, 480)
    main.minimumSize = Dimension(640, 480)
    main.pack()
    main.isVisible = true
}