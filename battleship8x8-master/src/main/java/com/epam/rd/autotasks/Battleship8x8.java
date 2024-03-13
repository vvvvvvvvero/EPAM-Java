package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        char letterShot = shot.charAt(0);

        int letterInt = 0;
        if (letterShot == 'A') {
            letterInt = 1;
        }
        if (letterShot == 'B') {
            letterInt = 2;
        }
        if (letterShot == 'C') {
            letterInt = 3;
        }
        if (letterShot == 'D') {
            letterInt = 4;
        }
        if (letterShot == 'E') {
            letterInt = 5;
        }
        if (letterShot == 'F') {
            letterInt = 6;
        }
        if (letterShot == 'G') {
            letterInt = 7;
        }
        if (letterShot == 'H') {
            letterInt = 8;
        }


        int digitShot = Integer.parseInt(String.valueOf(shot.charAt(1)), 10);
        int pos = (8 * (digitShot - 1) + letterInt) - 1;


        StringBuilder binaryString = new StringBuilder(Long.toBinaryString(ships));
        int length0 = binaryString.length();
        for (int i = 0; i < 64 - length0; i++) {
            binaryString.insert(0, '0');
        }


        StringBuilder sb = new StringBuilder(Long.toBinaryString(shots));
        int length = sb.length();
        for (int i = 0; i < 64 - length; i++) {
            sb.insert(0, '0');
        }

        int length2 = sb.length();

        if (binaryString.charAt(pos) == '1' && sb.charAt(pos) == '0') {
            sb.setCharAt(pos, '1');
            BigInteger bigInteger = new BigInteger(sb.toString(), 2);
            shots = bigInteger.longValue();
            return true;
        } else if (binaryString.charAt(pos) == '0' && sb.charAt(pos) == '0') {
            sb.setCharAt(pos, '1');
            BigInteger bigInteger = new BigInteger(sb.toString(), 2);
            shots = bigInteger.longValue();
        }
        return false;
    }

    public String state() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder shipsBinary = new StringBuilder(Long.toBinaryString(ships));
        int shipsLength = shipsBinary.length();
        for (int i = 0; i < 64 - shipsLength; i++) {
            shipsBinary.insert(0, '0');
        }
        StringBuilder shotsBinary = new StringBuilder(Long.toBinaryString(shots));
        int shotsLength = shotsBinary.length();
        for (int i = 0; i < 64 - shotsLength; i++) {
            shotsBinary.insert(0, '0');
        }

        int counter = 0;
        for (int i = 0; i < 64; i++) {

            if (shotsBinary.charAt(i) == '0' && shipsBinary.charAt(i) == '0') stringBuilder.append('.');
            if (shotsBinary.charAt(i) == '1' && shipsBinary.charAt(i) == '0') stringBuilder.append('×');
            if (shotsBinary.charAt(i) == '1' && shipsBinary.charAt(i) == '1') stringBuilder.append('☒');
            if (shotsBinary.charAt(i) == '0' && shipsBinary.charAt(i) == '1') stringBuilder.append('☐');

            if (++counter == 8 && i != 63) {
                stringBuilder.append('\n');
                counter = 0;
            }

        }
        return stringBuilder.toString();
    }
}
