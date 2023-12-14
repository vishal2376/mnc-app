package com.example.mncapp

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService

const val shortcut_mess_id = "id_mess"

object Shortcuts {
    @RequiresApi(Build.VERSION_CODES.N_MR1)
    fun setUp(context:Context){
        val shortcutManager:ShortcutManager? = getSystemService<ShortcutManager>(context,ShortcutManager::class.java)

        val intents:Array<Intent> = arrayOf(Intent(Intent.ACTION_VIEW,null,context,MainActivity::class.java),
        Intent(Intent.ACTION_VIEW,null,context,Mess::class.java))

        val shortcutMess: ShortcutInfo = ShortcutInfo.Builder(context, shortcut_mess_id)
            .setShortLabel("Mess")
            .setLongLabel("Mess Schedule")
            .setIcon(Icon.createWithResource(context,R.drawable.ic_outline_restaurant_24))
            .setIntents(intents)
            .build()

        shortcutManager!!.dynamicShortcuts = listOf(shortcutMess)

    }


}