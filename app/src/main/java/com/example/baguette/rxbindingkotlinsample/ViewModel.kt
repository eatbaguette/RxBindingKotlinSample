package com.example.baguette.rxbindingkotlinsample

import jp.keita.kagurazaka.rxproperty.ReadOnlyRxProperty
import jp.keita.kagurazaka.rxproperty.toReadOnlyRxProperty
import rx.Observable


/**
 * Created by monkey on 2018/01/31.
 */
class ViewModel(textChangeStream: io.reactivex.Observable<CharSequence>) {
    val text: ReadOnlyRxProperty<String>

    val upperCase: ReadOnlyRxProperty<String>
    val fileterI: ReadOnlyRxProperty<String>

    init {
        val textStream = textChangeStream
                .publish()
                .refCount()

        text = textStream
                .map(CharSequence::toString)
                .toReadOnlyRxProperty()


        upperCase = textStream
                .map(CharSequence::toString)
                .toReadOnlyRxProperty()

        fileterI = textStream
                .map(CharSequence::toString)
                .toReadOnlyRxProperty()
    }
}
