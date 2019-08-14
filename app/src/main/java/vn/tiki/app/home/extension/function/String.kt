package vn.tiki.app.home.extension.function

import java.lang.StringBuilder

/**
 * Time Complexity: O(n)
 * Memory complexity: O(n)
 */
fun String.divideIfPossible(): String {
    // convert input to String with no extra space, example: "  bitis   hunter " => "bitis hunter"
    val output = StringBuilder()
    this.forEach {
        if (it != ' ') {
            output.append(it)
        } else if (output.isNotEmpty() && output.last() != ' ') {
            output.append(it)
        }
    }

    // delete last index if it's space
    if (output.isNotEmpty() && output.last() == ' ') output.deleteCharAt(output.lastIndex)

    // apply algorithm to divide if keyword more than 1 word
    if (output.contains(" ")) {
        // position to add \n is nearest position to mid position of string
        val replacePosition = ((output.length - 1) / 2).let {
            // find nearest space position of $it
            var headCursor = it
            var tailCursor = it
            while (output[headCursor] != ' ' && output[tailCursor] != ' ') {
                headCursor--
                tailCursor++
            }
            if (output[headCursor] == ' ') headCursor else tailCursor
        }
        output.replace(replacePosition, replacePosition + 1, "\n")
    }

    return output.toString()
}