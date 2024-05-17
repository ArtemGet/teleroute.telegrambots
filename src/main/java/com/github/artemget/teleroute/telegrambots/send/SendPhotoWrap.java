/*
 * MIT License
 *
 * Copyright (c) 2024 Artem Getmanskii
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.artemget.teleroute.telegrambots.send;

import com.github.artemget.teleroute.send.Send;
import com.github.artemget.teleroute.send.SendException;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Send photo wrap.
 *
 * @since 0.1.0
 */
public final class SendPhotoWrap implements Send<AbsSender> {
    /**
     * Message.
     */
    private final SendPhoto message;

    /**
     * Main constructor. Construct SendPhotoWrap.
     *
     * @param message Instance of {@link SendPhoto}
     */
    public SendPhotoWrap(final SendPhoto message) {
        this.message = message;
    }

    @Override
    public void send(final AbsSender send) throws SendException {
        try {
            send.execute(this.message);
        } catch (final TelegramApiException exception) {
            throw new SendException(exception.getMessage(), exception);
        }
    }
}