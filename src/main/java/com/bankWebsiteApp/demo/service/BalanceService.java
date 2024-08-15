package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.cardConfiguration.CardCreditLimit;
import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.BalanceRepository;
import com.bankWebsiteApp.demo.repository.UserRepository;
import com.bankWebsiteApp.demo.validation.balanceValidate.BalanceValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;
    private final BalanceValidation balanceValidation;

    public Balance createOrUpdateBalance(Balance balance) {
        Long userId = balance.getAccountUserBank().getIdUser();
        balanceValidation.validateUserExistence(userId);

        boolean isFirstDeposit = balanceValidation.isFirstDeposit(userId);
        if (isFirstDeposit) {
            double generatedLimit = CardCreditLimit.generateLimitCredit(); // Certifique-se de que este método retorna um double
            balance.setCredit(generatedLimit);
            balance.setDebit(balance.getDebit()); // Define o valor de débito inicial

            UserBank userBank = userRepository.findById(userId).get();
            balance.setAccountUserBank(userBank);

            return balanceRepository.save(balance);
        } else {
            // Atualiza o saldo existente
            Balance existingBalance = balanceRepository.findByAccountUserBank_IdUser(userId).orElseThrow(() -> new MessageNotFoundException("Balance not found"));
            existingBalance.setDebit(existingBalance.getDebit() + balance.getDebit());
            return balanceRepository.save(existingBalance);
        }
    }

    public void updateBalanceForTransaction(Balance balance, double amount, String transactionType) {
        if (transactionType.equalsIgnoreCase("debit")) {
            if (balance.getDebit() < amount) {
                throw new MessageNotFoundException("Insufficient funds for debit transaction");
            }
            balance.setDebit(balance.getDebit() - amount);  // Desconta o valor do saldo de débito
        } else if (transactionType.equalsIgnoreCase("credit")) {
            if (balance.getCredit() < amount) {
                throw new MessageNotFoundException("Insufficient funds for credit transaction");
            }
            balance.setCredit(balance.getCredit() - amount);  // Desconta o valor do saldo de crédito
        }
        balanceRepository.save(balance);
    }
}
