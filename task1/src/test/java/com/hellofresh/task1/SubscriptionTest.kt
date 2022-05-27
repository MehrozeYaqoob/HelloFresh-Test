package com.hellofresh.task1

import junit.framework.TestCase
import org.junit.Test
import java.util.*

class SubscriptionTest : TestCase(){

    @Test
    fun `test delivery day of subscription`(){
        val date = Date()
        val subscription = Subscription(1, date,false)
        assertEquals(date, subscription.deliveryDay)
    }

    @Test
    fun `test id of subscription`(){
        val date = Date()
        val subscription = Subscription(1, date,false)
        assertEquals(1, subscription.id)
    }

    @Test
    fun `test isForFamily of subscription when true`(){
        val date = Date()
        val subscription = Subscription(1, date,true)
        assertEquals(true, subscription.isForFamily)
    }

    @Test
    fun `test isForFamily of subscription when false`(){
        val subscription = Task1TestData.provideSubscription()
        assertEquals(false, subscription.isForFamily)
    }
}
