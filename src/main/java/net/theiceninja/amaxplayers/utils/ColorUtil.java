package net.theiceninja.amaxplayers.utils;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

public final class ColorUtil {

    public static String color(@NotNull String str) {
        final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
        final String[] text = str.split(String.format(WITH_DELIMITER, "&"));

        StringBuilder finalText = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            if (text[i].equalsIgnoreCase("&")) {
                i++;
                if (text[i].charAt(0) == '#')
                    finalText.append(ChatColor.of(text[i].substring(0, 7))).append(text[i].substring(7));
                else
                    finalText.append(ChatColor.translateAlternateColorCodes('&', "&" + text[i]));
            } else
                finalText.append(text[i]);
        }

        return finalText.toString();
    }
}