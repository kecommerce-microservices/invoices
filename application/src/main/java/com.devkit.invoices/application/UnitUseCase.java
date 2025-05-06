package com.devkit.invoices.application;

public abstract class UnitUseCase<I> {

    public abstract void execute(I input);
}
