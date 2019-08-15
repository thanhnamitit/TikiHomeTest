package vn.tiki.app.home.screen.home

import vn.tiki.app.home.data.model.Keyword
import vn.tiki.app.home.extension.function.divideIfPossible

class ItemKeywordViewModel(val keyword : Keyword){
    val displayContent : String = keyword.body.divideIfPossible()
    val numberFromKeyword = keyword.body.hashCode()
}