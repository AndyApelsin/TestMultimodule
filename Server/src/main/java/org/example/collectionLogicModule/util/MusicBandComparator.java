package org.example.collectionLogicModule.util;

import org.example.collectionLogicModule.entity.MusicBand;

import java.util.Comparator;

public class MusicBandComparator implements Comparator<MusicBand> {
    @Override
    public int compare(MusicBand m1, MusicBand m2) {
        return m1.compareTo(m2);
    }
}
