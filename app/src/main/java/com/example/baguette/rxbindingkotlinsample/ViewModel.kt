package com.example.baguette.rxbindingkotlinsample

import jp.keita.kagurazaka.rxproperty.ReadOnlyRxProperty
import jp.keita.kagurazaka.rxproperty.toRxProperty

/**
 * Created by monkey on 2018/01/31.
 */
class ViewModel(textChangeStream: rx.Observable<CharSequence>) {
    val text: ReadOnlyRxProperty<String>

    val upperCase: ReadOnlyRxProperty<String>
    val fileterI: ReadOnlyRxProperty<String>

    init {
        val textStream = textChangeStream
                .publish()
                .refCount()

        text = textStream
                .map(CharSequence::toString)
                .toRxProperty()

        upperCase = textStream
                .map(CharSequence::toString)
                .map { it.toUpperCase() }
                .toRxProperty()

        fileterI = textStream
                .map(CharSequence::toString)
                .map { it.replace("apple", "", ignoreCase = true) }
                .toRxProperty()
    }
}
