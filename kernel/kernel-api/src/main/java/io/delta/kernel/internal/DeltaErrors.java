/*
 * Copyright (2024) The Delta Lake Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.delta.kernel.internal;

public final class DeltaErrors {
    private DeltaErrors() {}

    // TODO update to be user-facing exception with future exception framework
    //  (see delta-io/delta#2231) & document in method docs as needed (Table::getSnapshotAtVersion)
    public static RuntimeException nonReconstructableStateException(
            String tablePath, long version) {
        String message = String.format(
            "%s: Unable to reconstruct state at version %s as the transaction log has been " +
                "truncated due to manual deletion or the log retention policy and checkpoint " +
                "retention policy.",
            tablePath,
            version);
        return new RuntimeException(message);
    }

    // TODO update to be user-facing exception with future exception framework
    //  (see delta-io/delta#2231) & document in method docs as needed (Table::getSnapshotAtVersion)
    public static RuntimeException nonExistentVersionException(
            String tablePath, long versionToLoad, long latestVersion) {
        String message = String.format(
            "%s: Trying to load a non-existent version %s. The latest version available is %s",
            tablePath,
            versionToLoad,
            latestVersion);
        return new RuntimeException(message);
    }
}
