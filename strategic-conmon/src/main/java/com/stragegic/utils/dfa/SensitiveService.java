package com.stragegic.utils.dfa;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 敏感词过滤 dfa算法
 */
@Log4j2
@Component
public class SensitiveService {
    //敏感词库 先满足功能需求
    private static List<String> sensitiveWordsList = null;
    //敏感词库
    private static Map sensitiveWordsMap = null;
    // 最小匹配规则
    public static Integer minMatchTYpe = 1;
    // 最大匹配规则
    public static Integer maxMatchType = 2;


    @PostConstruct
    private void init() {

    }


    /**
     * 将敏感词加入HashMap 初始化map
     */
    private void initialSensitiveWord(String text) {
        sensitiveWordsMap = new HashMap();
        Map childMap = null;
        Map<String, String> newWordMap = null;

        childMap = sensitiveWordsMap;
        char[] wordChar = text.toCharArray();

        for (int x = 0; x < wordChar.length; x++) {
            char word = wordChar[x];
            Object o = childMap.get(word);
            if (Objects.isNull(o)) {
                newWordMap = new HashMap<>();
                newWordMap.put("isEnd", "0");
                childMap.put(word, newWordMap);
                //指向当前map,继续遍历
                childMap = newWordMap;
            } else {
                childMap = (Map) childMap.get(word);
            }

            if (x == wordChar.length - 1) {
                //最后一个
                childMap.put("isEnd", "1");
            }
        }
    }

    /**
     * 判断文本是否包含关键字
     *
     * @param txt       待判断文本
     * @param matchType 匹配类型： 1 最小匹配原则；2 最大匹配原则
     * @return true 包含；false 不包含
     */
    public boolean checkWord(String txt, Integer matchType) {
        if (txt == null || "".equals(txt)) {
            return false;
        }
        for (int i = 0; i < txt.length(); i++) {
            Integer matchFlag = checkSensitiveWords(txt, i, matchType);
            if (matchFlag > 0) {
                return true;
            }
        }
        return false;
    }

    private static Integer checkSensitiveWords(String txt, Integer start, Integer matchType) {
        //敏感词结束标志
        Boolean flag = false;
        char word;
        //匹配标识数默认为0
        Integer matchFlag = 0;
        Map childMap = sensitiveWordsMap;

        for (int i = start; i < txt.length(); i++) {
            word = txt.charAt(i);
            childMap = (Map) childMap.get(word);
            if (childMap == null) {
                //不存在该字打头的敏感词
                break;
            } else {
                //匹配标识+1
                matchFlag++;
                if ("1".equals(childMap.get("isEnd"))) {
                    flag = true;
                    if (minMatchTYpe.equals(matchType)) {
                        //最小匹配规则则跳出，否则继续匹配
                        break;
                    }
                }
            }
        }

        if (matchFlag < 2 || !flag) {
            //匹配长度需大于2才为词，并且敏感词已结束
            matchFlag = 0;
        }

        return matchFlag;
    }

}
