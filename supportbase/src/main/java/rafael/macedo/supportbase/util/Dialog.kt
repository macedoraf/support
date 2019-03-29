package rafael.macedo.supportbase.util

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AlertDialog
import android.view.Window.FEATURE_NO_TITLE
import rafael.macedo.supportbase.R

/**
 * Created by Rafael Macedo on 23/02/2019
 */

 interface OnRetryListener{

    fun onClickRetry()

    fun onClickDontRetry()

}
class Dialog {

    companion object {

        private var loadingDialog:Dialog? = null
        private var retryDialog:Dialog? = null

        fun showLoadingDialog(context: Context) {
            getInstanceLoadingDialog(context)?.show()

        }

        fun hideLoadingDialog(context: Context) {
            getInstanceLoadingDialog(context)?.dismiss()

        }

        fun showRetryDialog(context: Context,onRetryListener: OnRetryListener){
            getInstanceRetryDialog(context,onRetryListener)?.show()
        }

        private fun getInstanceLoadingDialog(context: Context):Dialog?{
            if(loadingDialog == null){
                val dialog = Dialog(context)
                dialog.requestWindowFeature(FEATURE_NO_TITLE)
                dialog.setContentView(R.layout.custom_dialog_layout)
                dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
                dialog.setCancelable(false)
                loadingDialog = dialog

            }

            return loadingDialog

        }

        private fun getInstanceRetryDialog(context: Context,onRetryListener: OnRetryListener):Dialog?{
            if(retryDialog == null){

                retryDialog = AlertDialog.Builder(context)
                        .setTitle(R.string.retry_defaut_title)
                        .setPositiveButton(R.string.retry_defaut_positive_mensage) { _, _ ->
                            onRetryListener.onClickRetry()
                        }
                        .setNegativeButton(R.string.retry_defaut_negative_mensage) { _, _ ->
                            onRetryListener.onClickDontRetry()
                        }
                        .create()


            }

            return retryDialog

        }
    }
}