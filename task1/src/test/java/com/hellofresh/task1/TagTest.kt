package com.hellofresh.task1

import junit.framework.TestCase
import org.junit.Test

class TagTest : TestCase(){
    @Test
    fun `test tag title`(){
        val tag = Tag(1,"popular")
        assertEquals("popular", tag.title)
    }

    @Test
    fun `test tag id`(){
        val tag = Tag(1,"popular")
        assertEquals(1, tag.id)
    }
}
