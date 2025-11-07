package com.nowni.fincalc.domain.sip.model

import com.nowni.fincalc.domain.sip.AnnuityDueComputeSip
import com.nowni.fincalc.domain.sip.ComputeSip
import com.nowni.fincalc.domain.sip.OrdinaryComputeSip

enum class SipType(val title: String, val computeSip: ComputeSip) {
    ORDINARY("Ordinary SIP", OrdinaryComputeSip),
    ANNUITY_DUE("Annuity Due SIP", AnnuityDueComputeSip),
}