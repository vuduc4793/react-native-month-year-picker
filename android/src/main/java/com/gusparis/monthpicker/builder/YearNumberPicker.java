package com.gusparis.monthpicker.builder;
// import android.util.Log;
class YearNumberPicker extends MonthYearNumberPicker {

  private static final int DEFAULT_SIZE = 408;

  @Override
  YearNumberPicker onScrollListener(MonthYearScrollListener scrollListener) {
    yearPicker.setOnScrollListener(scrollListener);
    yearPicker.setOnValueChangedListener(scrollListener);
    return this;
  }

  @Override
  YearNumberPicker build() {
    int year = props.value().getYear();
    int miniumYear = 2021;
    yearPicker.setMinValue(miniumYear);
    yearPicker.setMaxValue(miniumYear + DEFAULT_SIZE);
    yearPicker.setValue(year);
    // Log.i("year", " >> " + miniumYear + year);
    String[] years = new String[409];
    // int minYear = year - DEFAULT_SIZE;
    for(int i=0; i < years.length; i++) {
      years[i] = Integer.toString(miniumYear + i) + "年";
    }
    yearPicker.setDisplayedValues(years);
    return this;
  }

  @Override
  synchronized void setValue() {
    int year = yearPicker.getValue();
    int value = year;
    if (props.minimumValue() != null && year < props.minimumValue().getYear()) {
      value = props.minimumValue().getYear();
    } else if (props.maximumValue() != null && year > props.maximumValue().getYear()) {
      value = props.maximumValue().getYear();
    }
    yearPicker.setValue(value);
  }

  @Override
  int getValue() {
    return yearPicker.getValue();
  }
}
