package com.github.pedramrn.slick.uni;

import io.reactivex.Observable;

/**
 * @author : Pedramrn@gmail.com
 *         Created on: 2018-03-11
 */

public interface ViewExample {

    Observable<Integer> loadText();

    Observable<Boolean> likeComment();

    void setText(String text);

    void setLike(boolean liked);
}
