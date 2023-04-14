package pointofsale

interface ScreenOutput {
    fun print(output: String)
}

class TerminalOutput : ScreenOutput {
    override fun print(output: String) {
        println(output)
    }

}
