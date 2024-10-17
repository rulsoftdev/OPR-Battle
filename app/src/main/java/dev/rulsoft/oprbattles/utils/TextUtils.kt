package dev.rulsoft.oprbattles.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun AnnotatedString.Builder.Property(label: String, value: String, end: Boolean = false) {
    withStyle(ParagraphStyle(lineHeight = 18.sp)){
        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
            append("$label: ")
        }
        append(value)
        if (!end) {
            append("\n")
        }
    }
}