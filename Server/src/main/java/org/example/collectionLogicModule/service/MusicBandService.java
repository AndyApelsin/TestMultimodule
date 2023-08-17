package org.example.collectionLogicModule.service;

import org.example.collectionLogicModule.entity.MusicBand;
import org.example.collectionLogicModule.entity.MusicGenre;
import org.example.collectionLogicModule.entity.Person;
import org.example.collectionLogicModule.util.Exception.CollectionEmptyException;
import org.example.collectionLogicModule.util.MusicBandComparator;
import org.example.collectionLogicModule.util.dto.MusicBandDTO;
import org.example.collectionLogicModule.util.dto.MusicBandServiceDTO;
import org.example.collectionLogicModule.util.helper.XmlHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class MusicBandService {
    private boolean workState = true;
    private Queue<MusicBand> musicBandStorage;
    private final LocalDateTime initializingTime;

    public MusicBandService() {
        this.musicBandStorage = new PriorityQueue<>(new MusicBandComparator());
        this.initializingTime = LocalDateTime.now();
    }

    public void uploadMusicBands(String filename) {
        MusicBandServiceDTO serviceDTO;
        try {
            serviceDTO = XmlHelper.parseXmlToMusicBands(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("incorrect filepath");
        } catch (IOException e) {
            throw new RuntimeException("Problems with file");
        }
        for (MusicBandDTO musicBandDTO : serviceDTO.getMusicBandStorage()) {
            MusicBand musicBand = new MusicBand(musicBandDTO);
            this.musicBandStorage.add(musicBand);
        }
    }

    public String info() {
        return "Collection type: " + musicBandStorage.getClass() + "\n" +
                "Initializing time: " + initializingTime + "\n" +
                "Collection size: " + musicBandStorage.size() + "\n";
    }

    public String show() {
        StringBuilder stringBuilder = new StringBuilder();
        for (MusicBand musicBand : musicBandStorage) {
            stringBuilder.append(musicBand.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void add(MusicBand musicBand) {
        musicBandStorage.add(musicBand);
    }

    public boolean updateById(Integer id, MusicBand newMusicBand) {
        if(!musicBandStorage.removeIf(musicBand -> musicBand.getId() == id)){
            return false;
        }
        newMusicBand.setId(id);
        newMusicBand.setCreationDate(LocalDateTime.now());
        return musicBandStorage.add(newMusicBand);
    }

    public void removeById(Integer id) {
        musicBandStorage.removeIf(musicBand -> musicBand.getId() == id);
    }

    public void clear() {
        musicBandStorage.clear();
    }

    public void save() {
        List<MusicBandDTO> musicBandList = musicBandStorage
                .stream()
                .map(MusicBand::getMusicBandDTO)
                .collect(Collectors.toList());
        MusicBandServiceDTO musicBandServiceDTO = new MusicBandServiceDTO(musicBandList);
        XmlHelper.parseMusicBandsToXml(musicBandServiceDTO, "C:\\Users\\andye\\IdeaProjects\\testclientserver\\TestMultimodule\\Server\\src\\main\\resources\\saveOutput.xml");

    }

    //TODO executeScript Logic
    public void executeScriptByFilename(String filename) {

    }

    public void exit() {
        setWorkState(false);
    }

    public void removeFirst() throws CollectionEmptyException {
        if (!musicBandStorage.isEmpty()) {
            musicBandStorage.poll();
        } else {
            throw new CollectionEmptyException();
        }
    }

    public MusicBand removeHead() throws CollectionEmptyException {
        if (!musicBandStorage.isEmpty()) {
            return musicBandStorage.poll();
        } else {
            throw new CollectionEmptyException();
        }
    }

    public MusicBand minByCreationDate() throws CollectionEmptyException {
        return musicBandStorage
                .stream()
                .min(Comparator.comparing(MusicBand::getCreationDate))
                .orElseThrow(CollectionEmptyException::new);
    }

    public List<MusicBand> filterLessThanFrontMan(Person frontMan) {
        return musicBandStorage
                .stream()
                .filter(musicBand -> musicBand.getFrontMan().compareTo(frontMan) < 0)
                .toList();
    }

    public List<MusicGenre> getFieldAscendingGenre() {
        List<MusicGenre> resultList = new ArrayList<>();
        musicBandStorage
                .forEach(musicBand -> resultList.add(musicBand.getGenre()));
        return resultList;
    }

    public List<MusicBand> getAllMusicBands() {
        return new ArrayList<>(musicBandStorage);
    }

    public void setMusicBandStorage(Queue<MusicBand> musicBandStorage) {
        this.musicBandStorage = musicBandStorage;
    }

    public boolean getWorkState(){
        return workState;
    }

    private void setWorkState(boolean newWorkState){
        this.workState = newWorkState;
    }
}
