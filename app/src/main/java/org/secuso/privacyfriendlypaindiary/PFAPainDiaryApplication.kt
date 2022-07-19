package org.secuso.privacyfriendlypaindiary


import android.app.Application
import android.util.Log
import androidx.work.Configuration
import org.secuso.privacyfriendlybackup.api.pfa.BackupManager
import org.secuso.privacyfriendlypaindiary.backup.BackupCreator
import org.secuso.privacyfriendlypaindiary.backup.BackupRestorer


class PFAPainDiaryApplication : Application(), Configuration.Provider {
    override fun onCreate() {
        super.onCreate()
        BackupManager.backupCreator = BackupCreator()
        BackupManager.backupRestorer = BackupRestorer()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setMinimumLoggingLevel(Log.INFO).build()
    }
}