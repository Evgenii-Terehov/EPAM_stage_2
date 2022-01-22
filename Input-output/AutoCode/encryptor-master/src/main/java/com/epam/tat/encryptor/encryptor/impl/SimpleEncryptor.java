package com.epam.tat.encryptor.encryptor.impl;

import com.epam.tat.encryptor.datasource.IDataSource;
import com.epam.tat.encryptor.encryptor.ISimpleEncryptor;

public class SimpleEncryptor implements ISimpleEncryptor {

    private IDataSource dataSource;

    public SimpleEncryptor(IDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void changeLetters(char oldChar, char newChar) {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    @Override
    public void byteEncryption() {
        throw new UnsupportedOperationException("You need to implement this method");
    }

    @Override
    public void rot1() {
        throw new UnsupportedOperationException("You need to implement this method");
    }
}
