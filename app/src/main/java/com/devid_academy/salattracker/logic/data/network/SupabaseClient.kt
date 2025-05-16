package com.devid_academy.salattracker.logic.data.network

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

class SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "https://thijjyruvcrmsuawkghm.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRoaWpqeXJ1dmNybXN1YXdrZ2htIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDcxMzQ2MzIsImV4cCI6MjA2MjcxMDYzMn0.qi0JLso1WHL9A5699CkRVCrb_HeWWKAobmSPdCH9jDo"
    ) {
        install(Auth)
        install(Postgrest)
    }
}