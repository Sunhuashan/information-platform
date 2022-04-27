package com.shs.bysj.service.impl;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.shs.bysj.pojo.Announcement;
import com.shs.bysj.pojo.News;
import com.shs.bysj.pojo.Research;
import com.shs.bysj.pojo.Search;
import com.shs.bysj.repository.AnnoRepository;
import com.shs.bysj.repository.NewsRepository;
import com.shs.bysj.repository.ResearchRepository;
import com.shs.bysj.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: shs
 * @Data: 2022/4/26 21:04
 */
@Service
public class SearchService implements ISearchService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private AnnoRepository annoRepository;
    @Autowired
    private ResearchRepository researchRepository;
    @Override
    public List<News> searchNews(Search search) {
        String sentence = search.getContent();
        sentence = sentence.replaceAll(" ","");
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> keywords = segmenter.sentenceProcess(sentence);

        List<News> list = new ArrayList<>();
        for (String keyword : keywords) {
            list.addAll(newsRepository.findNewsByTitleKeyword(keyword));
        }
        List<Long> newsIds = list.stream().distinct().map(News::getId).collect(Collectors.toList());
        list = newsRepository.findAllByIdIn(newsIds);
        return list;
    }

    @Override
    public List<Announcement> searchAnnouncement(Search search) {
        String sentence = search.getContent();
        sentence = sentence.replaceAll(" ","");
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> keywords = segmenter.sentenceProcess(sentence);

        List<Announcement> list = new ArrayList<>();
        for (String keyword : keywords) {
            list.addAll(annoRepository.findAnnoByContentKeyword(keyword));
        }
        List<Long> annoIds = list.stream().distinct().map(Announcement::getId).collect(Collectors.toList());
        list = annoRepository.findAllByIdIn(annoIds);
        return list;
    }

    @Override
    public List<Research> searchResearch(Search search) {
        String sentence = search.getContent();
        sentence = sentence.replaceAll(" ","");
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> keywords = segmenter.sentenceProcess(sentence);

        List<Research> list = new ArrayList<>();
        for (String keyword : keywords) {
            list.addAll(researchRepository.findResearchByContentKeyword(keyword));
        }
        List<Long> researchIds = list.stream().distinct().map(Research::getId).collect(Collectors.toList());
        list = researchRepository.findAllByIdIn(researchIds);
        return list;
    }
}
