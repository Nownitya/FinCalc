package com.nowni.fincalc.domain.sip.model

import com.nowni.fincalc.domain.sip.AnnuityDueSipCalculator
import com.nowni.fincalc.domain.sip.OrdinarySipCalculator
import com.nowni.fincalc.domain.sip.SipCalculator

enum class SipType(val title: String, val sipCalculator: SipCalculator) {
    ORDINARY("Ordinary SIP", OrdinarySipCalculator),
    ANNUITY_DUE("Annuity Due SIP", AnnuityDueSipCalculator),
}