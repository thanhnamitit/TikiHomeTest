package vn.tiki.app.home

import org.junit.Test

import org.junit.Assert.*
import vn.tiki.app.home.extension.function.divideIfPossible

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DivideKeywordTest {

    @Test
    fun removeExtraSpace() {
        val input = " random string    "
        val output = input.divideIfPossible()
        assertEquals(output.length, output.trim().length)
    }

    @Test
    fun divideEmptyString() {
        val input = "   "
        val correctOutput = ""
        assertEquals(correctOutput, input.divideIfPossible())
    }

    @Test
    fun divideSingleWord() {
        val input = "xiaomi"
        val correctOutput = "xiaomi"
        assertEquals(correctOutput, input.divideIfPossible())
    }

    @Test
    fun divideMultiWordWithRegularSpace() {
        assertEquals("nguyễn\nnhật ánh", "nguyễn nhật ánh".divideIfPossible())
        assertEquals("kem chong\nnang", "kem chong nang".divideIfPossible())
        assertEquals("a\na a", "a a a".divideIfPossible())
        assertNotEquals("nguyễn nhật\nánh", "nguyễn nhật ánh".divideIfPossible())
        assertEquals("nguyễn\nnhật ánh", "nguyễn nhật ánh                 ".divideIfPossible())
        assertEquals("nguyễn\nnhật ánh", "         nguyễn nhật ánh".divideIfPossible())
        assertEquals("nguyễn\nnhật ánh", "       nguyễn nhật ánh               ".divideIfPossible())
    }

    @Test
    fun divideMultiWordWithIrregularSpace(){
        assertEquals("nguyễn\nnhật ánh", "nguyễn        nhật          ánh".divideIfPossible())
        assertNotEquals("nguyễn nhật\nánh", "nguyễn       nhật     ánh".divideIfPossible())
        assertEquals("nguyễn\nnhật ánh", "nguyễn       nhật          ánh                 ".divideIfPossible())
        assertEquals("nguyễn\nnhật ánh", "         nguyễn      nhật             ánh".divideIfPossible())
        assertEquals("nguyễn\nnhật ánh", "       nguyễn               nhật            ánh               ".divideIfPossible())
    }
}
