package com.verizon.billing;

//Base Plan Class
abstract class Plan {
abstract double getCallRate();
abstract double getSmsRate();
abstract double getDataRate();
}

