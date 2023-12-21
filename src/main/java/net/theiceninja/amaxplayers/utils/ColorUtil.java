package net.theiceninja.amaxplayers.utils;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ColorUtil {

    public static String color(@NotNull String str) {
        Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(str);

        String coloredMessage = matcher.replaceAll(matchResult -> {
            ChatColor color = ChatColor.of(matchResult.group().substring(1));
            return color.toString();
        });

        return ChatColor.translateAlternateColorCodes('&', coloredMessage);
    }
}