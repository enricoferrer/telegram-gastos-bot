package com.ferrer.enrico.gastos.bot.infrastructure.persistance.adapter.telegram;

import com.ferrer.enrico.gastos.bot.core.application.usecases.lancamento.SalvarLancamentoUseCase;
import com.ferrer.enrico.gastos.bot.core.application.usecases.usuario.RegistrarUsuarioUseCase;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TelegramBotAdapter extends TelegramLongPollingBot {
    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final SalvarLancamentoUseCase salvarLancamentoUseCase;
    private String textoInicio = "Bem vindo(a) ao bot de controle de despesas! Para se registrar, digite `/registrar {seu-nome}`";

    public TelegramBotAdapter(
            RegistrarUsuarioUseCase registrarUsuarioUseCase,
            SalvarLancamentoUseCase salvarLancamentoUseCase
    ){
        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
        this.salvarLancamentoUseCase = salvarLancamentoUseCase;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (message.equals("/start")){
                sendMessage(chatId, textoInicio);
            } else if(message.startsWith("/registrar")){
                return;
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
