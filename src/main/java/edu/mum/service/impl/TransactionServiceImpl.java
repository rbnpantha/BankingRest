package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.TransactionDao;
import edu.mum.domain.Transaction;
import edu.mum.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

 	@Autowired
	private TransactionDao transactionDao;

	public List<Transaction> getAllTransactions() {
		return transactionDao.getAllTransactions();
	}

	public Transaction getTransactionById(String transactionID) {
		return transactionDao.getTransactionById(transactionID);
	}
	
	public List<Transaction> getTransactionsByCategory(String category) {
		return transactionDao.getTransactionsByCategory(category);
	}

 	public void addTransaction(Transaction transaction) {
		   transactionDao.save(transaction);
	}
	
	public Transaction get(long transactionID) {
		return transactionDao.findOne(transactionID);
	}
	
	public List<Transaction> getTransactionsByDescOrder() {
		return transactionDao.getTransactionsByDescOrder();
	}
}
