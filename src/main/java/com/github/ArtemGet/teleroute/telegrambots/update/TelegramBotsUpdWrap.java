package com.github.ArtemGet.teleroute.telegrambots.update;


import com.github.ArtemGet.teleroute.update.UpdWrap;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

public class TelegramBotsUpdWrap implements UpdWrap<Update> {
    private final Update update;

    public TelegramBotsUpdWrap(final Update update) {
        this.update = update;
    }

    @Override
    public Integer id() {
        return this.update.getUpdateId();
    }

    @Override
    public Boolean isCommand() {
        return Optional.ofNullable(this.update.getMessage())
                .map(Message::isCommand)
                .orElse(false);
    }

    @Override
    public Optional<String> text() {
        return Optional.ofNullable(this.update.getMessage())
                .map(Message::getText);
    }

    @Override
    public Update src() {
        return this.update;
    }
}
