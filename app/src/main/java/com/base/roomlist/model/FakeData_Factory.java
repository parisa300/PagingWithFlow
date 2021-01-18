package com.base.roomlist.model;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FakeData_Factory implements Factory<FakeData> {
  @Override
  public FakeData get() {
    return newInstance();
  }

  public static FakeData_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FakeData newInstance() {
    return new FakeData();
  }

  private static final class InstanceHolder {
    private static final FakeData_Factory INSTANCE = new FakeData_Factory();
  }
}
